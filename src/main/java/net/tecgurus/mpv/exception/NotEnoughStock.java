package net.tecgurus.mpv.exception;

public class NotEnoughStock extends RuntimeException{
	public NotEnoughStock(String message) {
		super(message);
	}
}
