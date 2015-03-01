package org.usfirst.frc.team354.robot;

import org.usfirst.frc.team354.robot.commands.ActivateReceiveMode;
import org.usfirst.frc.team354.robot.commands.LowerLift;
import org.usfirst.frc.team354.robot.commands.LowerShelf;
import org.usfirst.frc.team354.robot.commands.RaiseLift;
import org.usfirst.frc.team354.robot.commands.RaiseShelf;
import org.usfirst.frc.team354.robot.commands.StartLiftRollers;
import org.usfirst.frc.team354.robot.commands.StartShelfRollers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	private final Joystick driverStick;
	private final Joystick codriverStick;
	
	public OI() {
		
		driverStick = new Joystick(RobotMap.driverJoystick);
		codriverStick = new Joystick(RobotMap.codriverJoystick);
		
		//Lift System commands
		getButton(RobotMap.driverJoystick, RobotMap.liftUpButton)
			.whileHeld(new RaiseLift());
		getButton(RobotMap.driverJoystick, RobotMap.liftDownButton)
			.whileHeld(new LowerLift());
		
		getButton(RobotMap.driverJoystick, 8)
			.whileHeld(new StartLiftRollers());
		getButton(RobotMap.driverJoystick, 6)
			.whileHeld(new StartLiftRollers(true));
		
		//Shelf System Commands
		getButton(RobotMap.driverJoystick, RobotMap.shelfRaiseButton)
			.whileHeld(new RaiseShelf());
		getButton(RobotMap.driverJoystick, RobotMap.shelfLowerButton)
			.whileHeld(new LowerShelf());
		
		getButton(RobotMap.driverJoystick, 7)
			.whileHeld(new StartShelfRollers());
		getButton(RobotMap.driverJoystick, 5)
			.whileHeld(new StartShelfRollers(true));
		
		//Specials
		getButton(RobotMap.driverJoystick, RobotMap.autoGateModeButton)
			.whenPressed(new ActivateReceiveMode());
	}
	
	//Joystick value interfaces
	public double getDriverStickX() {
		return driverStick.getX();
	}
	
	public double getDriverStickY() {
		return driverStick.getY();
	}
	
	public double getDriverStickZ() {
		return driverStick.getZ();
	}
	
	public JoystickButton getButton(int stick, int button) {
		switch(stick) {
			case RobotMap.driverJoystick:
				return new JoystickButton(driverStick, button);
			case RobotMap.codriverJoystick:
				return new JoystickButton(codriverStick, button);
			default:
				return null;
		}
	}
	
	public boolean getButtonState(int stick, int button) {
		return getButton(stick, button).get();
	}
}

