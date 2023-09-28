package UniversityEvent.controller;

import UniversityEvent.model.EventModel;
import UniversityEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;
    //add event
    @PostMapping("/addEvent")
    public String addEvent(@RequestBody List<EventModel> events){
        return  eventService.addEvent(events);
    }

    // update event
    @GetMapping("/getAllEvents/date")
    public List<EventModel> getAllEvents(@RequestParam LocalDate date){
        return (List<EventModel>) eventService.getAllEvents(date);
    }

    //delete event

    @DeleteMapping("delete/id/{id}")
    public String removeEvent(@PathVariable List<Integer> id){
        return  eventService.removeEvent(id);
    }


    //get allEvent by date

    @PutMapping("update/department/id/{id}")
    public String updateEvent(@PathVariable Integer id, @RequestParam String myEvent){
        return  eventService.updateEvent(id,myEvent);
    }
    @GetMapping("getAllEvent")
    public List<EventModel> getAllEvent(){
        return eventService.getAll();
    }
}
