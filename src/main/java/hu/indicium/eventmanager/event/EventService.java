package hu.indicium.eventmanager.event;

import java.util.*;

import org.springframework.stereotype.*;

import hu.indicium.eventmanager.event.request.EventRequest;
import hu.indicium.eventmanager.question.Question;
import hu.indicium.eventmanager.question.QuestionService;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private QuestionService questionService;

    public EventService(EventRepository eventRepository, QuestionService questionService) {
        this.eventRepository = eventRepository;
        this.questionService = questionService;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(EventRequest eventRequest) {
        Event event = this.eventReqToEvent(eventRequest, null);
        return eventRepository.save(event);
    }

    public Event updateEventById(long eventId, EventRequest eventRequest) {
        Event event = findEventById(eventId);

        if (!event.equals(null)) {
            this.eventReqToEvent(eventRequest, event);
            return eventRepository.save(event);
        }

        return null;
    }

    public void deleteEventById(long eventId) {
        eventRepository.deleteById(eventId);
    }

    public Event findEventById(long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    private Event eventReqToEvent(EventRequest eventRequest, Event event) {
        if (event == null) {
            event = new Event();
        }

        event.setTitle(eventRequest.getTitle());
        event.setDescription(eventRequest.getDescription());
        event.setStartDate(eventRequest.getStartDate());
        event.setEndDate(eventRequest.getEndDate());
        event.setStatus(eventRequest.getStatus());
        event.setLocation(eventRequest.getLocation());
        event.setCategories(eventRequest.getCategories());
        event.setSlug(eventRequest.getSlug());

        List<Question> questions = new ArrayList<Question>();
        for (Long questionId : eventRequest.getQuestions()) {
            questions.add(questionService.findQuestionById(questionId));
        }
        event.setQuestions(questions);

        return event;
    }
}
