package mediator;

//Mediator interface
public interface Mediator<Colleague> {
	public void send(String message, Colleague colleague);
}