package org.usfirst.frc.team354.robot;

public class Constants {
	public static final int LIFT_SAFE_HEIGHT = 6300;
	
	public static final int LIFT_HIGH_MARK = 7690;
	public static final int LIFT_MID_MARK = 6055;
	public static final int LIFT_LOW_MARK = 1325;
	
	public static final int SHELF_OPTIMUM_ANGLE = -272;
	
	public static final int LIFT_BUFFER = 2;
	public static final int SHELF_BUFFER = 5;
	
	public static final double CRAB_EXPO_VALUE = 4.0;
	public static final double DRIVE_EXPO_VALUE = 4.0;
	
	public static final double MAX_TURN_SPEED = 0.7;
	
	public static final double SHELF_ROLLER_SPEED = 0.6;
	public static final double SHELF_MOTOR_SPEED = 0.7;
	
	public static final double LIFT_ROLLER_SPEED = 0.6;
	public static final double LIFT_MOTOR_SPEED = 1.0;
	
	public static final String DASH_LIFT_ENCODER_OK = "Lift Encoder OK";
	public static final String DASH_LIFT_ENCODER_VALUE = "Lift Encoder Position";
	public static final String DASH_SHELF_ENCODER_OK = "Shelf Encoder OK";
	public static final String DASH_SHELF_ENCODER_VALUE = "Shelf Encoder Position";
	public static final String DASH_CURRENT_COMMAND = "Currently Running Commands";
	
	public static final String DASH_HAS_LOAD = "Tote Loaded";
	public static final String DASH_SAFE_TO_MOVE_SHELF = "Safe To Move Shelf";
}
