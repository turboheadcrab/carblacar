package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.forms.TripForm;
import ru.kpfu.itis.model.*;
import ru.kpfu.itis.service.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class TripsController {

    @Autowired
    TripsService tripsService;

    @Autowired
    BookingService bookingService;

    @Autowired
    ReviewsService reviewsService;

    @Autowired
    DriversService driversService;

    @Autowired
    AutosService autosService;

    @Autowired
    PassengersService passengersService;

    @Autowired
    UsersService usersService;


    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/newtrip", method = RequestMethod.GET)
    public String newTripPage(ModelMap modelMap, Principal principal) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        User userInfo = usersService.findById(userId);
        List<Automobile> automobileList = userInfo.getDriver().getAutomobileList();
        modelMap.put("automobileList", automobileList);
        return "newtrip";
    }

    @RequestMapping(value = "/newtrip", method = RequestMethod.POST)
    public String newTrip(@ModelAttribute TripForm tripForm, Principal principal) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        User userInfo = usersService.findById(userId);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = null;
        try {
            date = formatter.parse(tripForm.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String autoid = tripForm.getAuto().split(" ")[0];
        Long id = Long.parseLong(autoid);

        Trip trip = new Trip();
        trip.setDriver(userInfo.getDriver());
        trip.setAuto(autosService.findById(id));
        trip.setDeparture(tripForm.getDeparture());
        trip.setDestination(tripForm.getDestination());
        trip.setDate(date);
        trip.setPrice(tripForm.getPrice());
        trip.setCount(tripForm.getCount());
        trip.setStatus("Ожидание");
        trip.setInfo(tripForm.getInfo());
        trip.setPassengers(new ArrayList<Passenger>());

        tripsService.addTrip(trip);

        return "redirect:/users/" + userInfo.getId();
    }

    @RequestMapping(value = "/trips/{trip_id:\\d+}", method = RequestMethod.GET)
    public String joinTripPage(ModelMap modelMap, @PathVariable Long tripId) {
        Trip trip = tripsService.findById(tripId);
        modelMap.put("trip", trip);
        return "jointrip";
    }

    @RequestMapping(value = "/trips/{tripId:\\d+}", method = RequestMethod.POST)
    public String JoinTrip(@ModelAttribute Booking booking, @PathVariable Long tripId) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        User user = usersService.findById(userId);
        booking.setTrip(tripsService.findById(tripId));
        booking.setPassenger(user.getPassenger());
        bookingService.addBooking(booking);
        return "redirect:/users/" + user.getId();
    }

    @RequestMapping(value = "/bookings/{bookingId:\\d+}/conf", method = RequestMethod.GET)
    public String confirmBooking(@PathVariable Long bookingId) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        Booking booking = bookingService.findById(bookingId);
        booking.setConfirm("yes");
        Trip trip = booking.getTrip();
        trip.getPassengers().add(booking.getPassenger());
        trip.setCount(trip.getCount() - booking.getCount());
        tripsService.update(trip);
        bookingService.update(booking);
        return "redirect:/users/" + userId;
    }

    @RequestMapping(value = "/bookings/{bookingId:\\d+}/deny", method = RequestMethod.GET)
    public String denyBooking(@PathVariable Long bookingId) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        Booking booking = bookingService.findById(bookingId);
        booking.setConfirm("no");
        bookingService.update(booking);
        return "redirect:/users/" + userId;
    }

    @RequestMapping(value = "/trips/{tripId:\\d+}/status", method = RequestMethod.GET)
    public String tripStatusPage(@PathVariable Long tripId, ModelMap modelMap) {
        Trip trip = tripsService.findById(tripId);
        modelMap.put("trip", trip);
        return "tripstatus";
    }

    @RequestMapping(value = "/trips/{tripId:\\d+}/status", method = RequestMethod.POST)
    public String tripStatus(@PathVariable Long tripId, @RequestParam String status) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        Trip trip = tripsService.findById(tripId);
        trip.setStatus(status);
        tripsService.update(trip);
        return "redirect:/users/" + userId;
    }

    @RequestMapping(value = "/trips/{tripId:\\d+}/review", method = RequestMethod.GET)
    public String tripReviewPage(@PathVariable Long tripId, ModelMap modelMap) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        Trip trip = tripsService.findById(tripId);
        modelMap.put("trip", trip);
        return "tripreview";
    }

    @RequestMapping(value = "/trips/{tripId:\\d+}/review", method = RequestMethod.POST)
    public String tripReview(@PathVariable Long tripId, @ModelAttribute Review review) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if(userId == null) {
            return "login";
        }
        User user = usersService.findById(userId);
        Trip trip = tripsService.findById(tripId);
        review.setUser(user);
        review.setTrip(trip);
        reviewsService.addReview(review);
        if (user.getDriver() != null && trip.getDriver().getUser().getId() == user.getId()) {
            for (Passenger passenger : trip.getPassengers()) {
                passenger.setRating(passenger.getRating() + review.getGrade());
                passengersService.update(passenger);
            }

        } else {
            for (Passenger passenger : trip.getPassengers()) {
                if (passenger.getUser().getId() == user.getId()) {
                    Driver driver = trip.getDriver();
                    driver.setRating(driver.getRating() + review.getGrade());
                    driversService.update(driver);
                    break;
                }
            }

        }

        return "redirect:/users/" + user.getId();
    }

    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public String TripsPage(ModelMap modelMap) {
        List<Trip> trips = tripsService.findByStatusOrderDate();
        modelMap.put("trips", trips);
        return "trips";
    }

    @RequestMapping(value = "/trips/find", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Trip> getTrips(HttpServletRequest request) {
        String departure = request.getParameter("departure");
        String destination = request.getParameter("destination");
        List<Trip> trips = tripsService.findBySearch(departure, destination);
        return trips;
    }
}

