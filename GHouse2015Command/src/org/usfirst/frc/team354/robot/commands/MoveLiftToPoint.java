package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Constants;
import org.usfirst.frc.team354.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLiftToPoint extends Command {
	private int targetPoint;
	private boolean ignoreLow = false;
	private boolean ignoreHigh = false;
	private boolean forceStop = false;
	
    public MoveLiftToPoint(int target, boolean ignoreLow, boolean ignoreHigh) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.targetPoint = target;
    	this.ignoreLow = ignoreLow;
    	this.ignoreHigh = ignoreHigh;
    	
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//on the lift, positive numbers are UP
    	if (!ignoreLow && Robot.lift.encoderValue() < targetPoint - Constants.LIFT_BUFFER) {
    		//we are lower, we need to go up
    		Robot.lift.raise();
    	}
    	else if (!ignoreHigh && Robot.lift.encoderValue() > targetPoint + Constants.LIFT_BUFFER) {
    		Robot.lift.lower();
    	}
    	else {
    		Robot.lift.stop();
    		forceStop = true; //force a stop
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//We are done if we are within our buffer range
    	return (!(Robot.lift.encoderValue() < targetPoint - Constants.LIFT_BUFFER || 
    			Robot.lift.encoderValue() > targetPoint + Constants.LIFT_BUFFER)) 
    			|| forceStop;
//    	boolean result = (Robot.lift.encoderValue() > targetPoint - Constants.LIFT_BUFFER &&
//        				  Robot.lift.encoderValue() < targetPoint + Constants.LIFT_BUFFER);
//    	if (result) {
//    		System.out.println("Lift is at point");
//    	}
//    	return result;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
