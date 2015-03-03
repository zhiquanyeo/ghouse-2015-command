package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Constants;
import org.usfirst.frc.team354.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperatorMecDrive extends Command {
	
	private double maxSpeed = 0.5;
	
	public OperatorMecDrive() {
		this(0.5);
	}
	
    public OperatorMecDrive(double maxSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	if (maxSpeed > 1.0)
    		maxSpeed = 1.0;
    	if (maxSpeed < 0.0)
    		maxSpeed = 0.0;
    	
    	this.maxSpeed = maxSpeed;
    	
    	requires(Robot.chassis);
    }

    public String getName() {
    	return "OperatorMecDrive - " + maxSpeed;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double crabVal = expo(Robot.oi.getDriverStickX(), Constants.CRAB_EXPO_VALUE);
    	double driveVal = expo(Robot.oi.getDriverStickY(), Constants.DRIVE_EXPO_VALUE);
    	double turnVal = expo(Robot.oi.getDriverStickZ(), Constants.DRIVE_EXPO_VALUE);
    	
    	//Clamp turn speed
    	turnVal *= maxSpeed;
    	
    	//crab speed at full power
    	//crabVal *= maxSpeed;
    	driveVal *= maxSpeed;
    	
    	//TODO We can switch to mecanum by using this
    	Robot.chassis.meccanumDrive(driveVal, crabVal, turnVal);
    	Robot.chassis.meccanumDrive(crabVal, driveVal, turnVal);
    	//Robot.chassis.meccanumDrive(crabVal, driveVal, turnVal);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double expo(double input, double expoValue) {
    	double multiplier = 1.0;
    	if (input < 0) {
    		input = input * -1.0;
    		multiplier = -1.0;
    	}
    	double yVal = (Math.exp(expoValue * input) - 1) / (Math.exp(expoValue) - 1);
    	return multiplier * yVal;
    }
}
