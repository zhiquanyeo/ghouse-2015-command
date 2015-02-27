package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperatorHDrive extends Command {
	
	private static final double CRAB_EXPO_VALUE = 4.0;
	private static final double DRIVE_EXPO_VALUE = 4.0;
	private static final double MAX_TURN_SPEED = 0.7;

    public OperatorHDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double crabVal = expo(Robot.oi.getDriverStickX(), CRAB_EXPO_VALUE);
    	double driveVal = expo(Robot.oi.getDriverStickY(), DRIVE_EXPO_VALUE);
    	double turnVal = expo(Robot.oi.getDriverStickZ(), DRIVE_EXPO_VALUE);
    	
    	//Clamp turn speed
    	turnVal *= MAX_TURN_SPEED;
    	
    	Robot.chassis.hDrive(-driveVal, -turnVal, -crabVal);
    	
    	//TODO We can switch to mecanum by using this
    	//Robot.chassis.meccanumDrive(crabVal, driveVal, turnVal);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //Never finishes
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
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
