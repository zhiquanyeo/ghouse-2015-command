package org.usfirst.frc.team354.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// JOYSTICKS
	public static final int driverJoystick = 0;
	public static final int codriverJoystick = 1;
	
	// JOYSTICK BUTTONS
	//co-driver
	public static final int liftUpButton = 4;
	public static final int liftDownButton = 2;
	public static final int shelfRaiseButton = 3;
	public static final int shelfLowerButton = 1;
	public static final int liftRollerButton = 8;
	public static final int liftRollerReverseButton = 6;
	public static final int shelfRollerButton = 7;
	public static final int shelfRollerReverseButton = 5;
	
	//Driver
	public static final int shelfServoControlButton = 2;
	public static final int maxSpeedButton = 8;
	public static final int autoReceiveModeButton = 3;
	
	// DRIVETRAIN MOTORS
	public static final int frontLeftMotor = 0;
	public static final int frontRightMotor = 1;
	public static final int backLeftMotor = 2;
	public static final int backRightMotor = 3;
	
	// LIFT SYSTEM
	public static final int liftMotor = 4;
	public static final int liftRoller = 7;
	public static final int liftEncoderA = 7;
	public static final int liftEncoderB = 8;
	public static final int liftTopSwitch = 0;
	public static final int liftBottomSwitch = 1;
	
	// SHELF SYSTEM
	public static final int shelfMotor = 5;
	public static final int shelfRoller = 6;
	public static final int shelfEncoderA = 5;
	public static final int shelfEncoderB = 6;
	public static final int shelfLoweredSwitch = 2; //was OPEN
	public static final int shelfRaisedSwitch = 3; //was CLOSED
	public static final int shelfContactSwitch = 4;
	
	//SERVOS
	public static final int shelfServoLeft = 8;
	public static final int shelfServoRight = 9;
}
