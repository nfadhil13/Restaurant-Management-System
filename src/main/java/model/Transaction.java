package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
	private int transactionNumber;
	private long totalPayment;
	private LocalDateTime transactionTime;
	private Booking booking;
	private List<Purchase> purchases = new ArrayList<>();
	
	public Transaction(int transactionNumber, long totalPayment, LocalDateTime transactionTime,
			Booking booking, List<Purchase> purchases) {
		super();
		this.transactionNumber = transactionNumber;
		this.totalPayment = totalPayment;
		this.transactionTime = transactionTime;
		this.booking = booking;
		this.purchases = purchases;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public long getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(long totalPayment) {
		this.totalPayment = totalPayment;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
}
