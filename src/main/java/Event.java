import java.io.Serializable;

public class Event implements Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String description; //Поле может быть null
    private EventType eventType; //Поле может быть null

    public Event(long id, String name, String description, EventType eventType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public EventType getEventType() {
        return eventType;
    }
}
