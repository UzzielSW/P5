public class ElevatorProgram
{
	public static void main(String [] args)
	{
		Elevator elevator = new Elevator();
		elevator.goToFloor(5);
		elevator.openDoors();
		elevator.closeDoors();
		elevator.goToFloor(3);
		elevator.openDoors();
		elevator.closeDoors();
		elevator.goToFloor(1);
		elevator.openDoors();

		Elevator two = new Elevator(10);
		two.goToFloor(3);
		two.openDoors();
		two.closeDoors();
		two.goToFloor(22);
		two.openDoors();
	}
}