package com.mydealership.model;

public class CarLot {
	private int carId;
	private boolean isOwned;
	private int userId;
	private String carMaker;
	private String carType;
	private String carModel;
	private String carColor;
	private String carYear;
	private boolean isNew;
	private int odometerReading;
	private float price;
	
	public CarLot() {
		super();
	}

	public CarLot(int carId, boolean isOwned, int userId, String carMaker, String carType, String carModel,
			String carColor, String carYear, boolean isNew, int odometerReading, float price) {
		super();
		this.carId = carId;
		this.isOwned = isOwned;
		this.userId = userId;
		this.carMaker = carMaker;
		this.carType = carType;
		this.carModel = carModel;
		this.carColor = carColor;
		this.carYear = carYear;
		this.isNew = isNew;
		this.odometerReading = odometerReading;
		this.price = price;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public int getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(int odometerReading) {
		this.odometerReading = odometerReading;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carColor == null) ? 0 : carColor.hashCode());
		result = prime * result + carId;
		result = prime * result + ((carMaker == null) ? 0 : carMaker.hashCode());
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result + ((carYear == null) ? 0 : carYear.hashCode());
		result = prime * result + (isNew ? 1231 : 1237);
		result = prime * result + (isOwned ? 1231 : 1237);
		result = prime * result + odometerReading;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarLot other = (CarLot) obj;
		if (carColor == null) {
			if (other.carColor != null)
				return false;
		} else if (!carColor.equals(other.carColor))
			return false;
		if (carId != other.carId)
			return false;
		if (carMaker == null) {
			if (other.carMaker != null)
				return false;
		} else if (!carMaker.equals(other.carMaker))
			return false;
		if (carModel == null) {
			if (other.carModel != null)
				return false;
		} else if (!carModel.equals(other.carModel))
			return false;
		if (carType == null) {
			if (other.carType != null)
				return false;
		} else if (!carType.equals(other.carType))
			return false;
		if (carYear == null) {
			if (other.carYear != null)
				return false;
		} else if (!carYear.equals(other.carYear))
			return false;
		if (isNew != other.isNew)
			return false;
		if (isOwned != other.isOwned)
			return false;
		if (odometerReading != other.odometerReading)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarLot [Vehicle #" + carId + ", Maker = " + carMaker + ", Type = " + carType + ", Model = " + carModel
				+ ", Color = " + carColor + ", Year = " + carYear + ", New = " + isNew + ", Odometer Reading = "
				+ odometerReading + ", Price = " + price + "]" + "\n";
	}

	

	
	
	

}
