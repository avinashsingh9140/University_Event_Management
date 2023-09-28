package UniversityEvent.service;

import UniversityEvent.model.EventModel;
import UniversityEvent.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;

        // add event
    public String addEvent(List<EventModel> events) {
         eventRepo.saveAll(events);
         return "event added";
    }
        // get allEvent
        public List<EventModel> getAllEvents(LocalDate date) {
            return eventRepo.findByDate(date);
        }

    //delete event
    public String removeEvent(List<Integer> id) {
        eventRepo.deleteAllById(id);
        return  "Event deleted";
    }

        //update event

    public String updateEvent(Integer id, String myEvent) {
        EventModel event=eventRepo.findById(id).orElse(null);
        if(event != null){
            event.setEventName(myEvent);
            eventRepo.save(event);
            return "event updated !";
        }
        return "No event found!";
        }


    public List<EventModel> getAll() {
        return eventRepo.findAll();
    }
}
