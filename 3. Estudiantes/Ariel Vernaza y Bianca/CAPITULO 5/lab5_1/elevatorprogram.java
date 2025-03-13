public class ElevatorProgram
{
	public static void main(String [] args)
	{
		Elevator elevator = new Elevator();
		elevator.currentFloor = 1;

		elevator.goToFloor(5);
		elevator.openDoors();
		elevator.closeDoors();
		elevator.goToFloor(3);
		elevator.openDoors();
		elevator.closeDoors();
		elevator.goToFloor(1);
		elevator.openDoors();

		Elevator two = new Elevator();
		two.currentFloor = 10;
		two.goToFloor(3);
		two.openDoors();
		two.closeDoors();
		two.goToFloor(22);
		two.openDoors();
	}
}