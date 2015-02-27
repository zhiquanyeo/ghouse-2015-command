package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLiftToPoint extends Command {
	private int targetPoint;
	
	private static final int BUFFER = 2;
	
    public MoveLiftToPoint(int target) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	targetPoint = target;
    	
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//on the lift, positive numbers are UP
    	if (Robot.lift.encoderValue() < targetPoint - BUFFER) {
    		//we are lower, we need to go up
    		Robot.lift.raise();
    	}
    	else if (Robot.lift.encoderValue() > targetPoint + BUFFER) {
    		Robot.lift.lower();
    	}
    	else {
    		Robot.lift.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//We are done if we are within our buffer range
        return (Robot.lift.encoderValue() >= targetPoint - BUFFER &&
        		Robot.lift.encoderValue() <= targetPoint + BUFFER);
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