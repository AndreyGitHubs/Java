public class HomeSixOne {
    int bigSlot;
    int mediumSlot;
    int smallSlot;

    public void ParkingSystem(int big, int medium, int small) {
        this.bigSlot = big;
        this.mediumSlot = medium;
        this.smallSlot = small;
    }

    public boolean addCar(int carType) {
        boolean car;
        if (carType == 1 && bigSlot > 0) {
            car = true;
            bigSlot--;
        } else if (carType == 2 && mediumSlot > 0) {
            car = true;
            mediumSlot--;
        } else if (carType == 3 && smallSlot > 0) {
            car = true;
            smallSlot--;
        } else
            car = false;
        return car;
    }
}
