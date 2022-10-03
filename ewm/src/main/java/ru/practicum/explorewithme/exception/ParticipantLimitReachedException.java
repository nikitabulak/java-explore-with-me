package ru.practicum.explorewithme.exception;

public class ParticipantLimitReachedException extends RuntimeException{
    public ParticipantLimitReachedException() {
        super("Participant limit reached");
    }
}
