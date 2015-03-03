package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This mode raises the lift to a safe point and then lowers the shelf
 * to an appropriate point
 * 
 * This is a sequential action of raising (if necessary) the lift to an appropriate height
 * and then lowering the shelf to it's optimum position.
 * 
 * The lift only needs to be HIGHER than the safe point, so we pass false to ignoreLow 
 * (which makes sure that we move the lift out of the way), and true to ignoreHigh, which 
 * lets the lift stay if it's already past the safe point
 */
public class ActivateReceiveMode extends CommandGroup {
    
    public  ActivateReceiveMode() {
    	addSequential(new SafelyMoveLiftToPoint(Constants.LIFT_HIGH_MARK, false, true));
    	addSequential(new FullyLowerShelf());
    	addSequential(new SafelyMoveShelfToPoint(Constants.SHELF_OPTIMUM_ANGLE));
    	addSequential(new ShelfReceiveMode()); //Turn on the rollers and wait for load
    	addSequential(new FullyLowerShelf());
    	addSequential(new FullyLowerLift());
    	//addSequential(new SafelyMoveLiftToPoint(Constants.LIFT_HIGH_MARK, false, true));
    	//Standby to receive
    }
}
