package plugins.quorum.Libraries.Interface.Accessibility.IOS;

import org.robovm.apple.uikit.*;
import quorum.Libraries.Interface.Controls.Checkbox_;
import quorum.Libraries.Interface.Controls.ToggleButton_;
import quorum.Libraries.Interface.Item_;

public class CheckboxIOS extends ItemIOS {
    @Override
    public boolean isAccessibilityElement() {
        return true;
    }

    public CheckboxIOS(UIAccessibilityContainer container) {
        super(container);
    }

    Checkbox_ checkbox;

    public void setCheckbox(Checkbox_ checkbox) {
        this.checkbox = checkbox;
    }

    public void Initialize(Checkbox_ checkbox) {
        setCheckbox(checkbox);
        UIAccessibilityTraits traits = UIAccessibilityTraits.None;
        this.setAccessibilityTraits(traits);
        super.Initialize(checkbox);
    }


    //worked on this together: Aidan and Nirbhay. Need to test before pushing.
    /*Current objective(s):
        -Checkbox doesn't uncheck with screen reader
     */
    @Override
    public boolean activate() {
        //create boolean for current state
        boolean isToggled = checkbox.GetToggleState();
        //other boolean for readability
        boolean oppositeState = !isToggled;
        //set the toggle state to opposite of current
        checkbox.SetToggleState(oppositeState);
        //click the mouse
        checkbox.ClickedMouse();
        //set the traits and value depending on toggled or not
        setAccessibilityTraits(oppositeState ? UIAccessibilityTraits.Selected : UIAccessibilityTraits.None);
        setAccessibilityValue(oppositeState ? "Checked" : "Unchecked");
        //post the notification
        UIAccessibility.postNotification(UIAccessibility.Notification.Announcement, new NSString(oppositeState ? "Checked" : "Unchecked"));
    //return opposite state
    return oppositeState;
    }
//
//    ***OLD CODE FOR REFERENCE***
//
//    @Override
//    public boolean activate() {
//        boolean isToggled = checkbox.GetToggleState();
//        if (isToggled == true) {
//            checkbox.Activate();
//            checkbox.SetToggleState(false);
//            checkbox.ClickedMouse();
//            return false;
//        } else {
//            checkbox.Activate();
//            checkbox.SetToggleState(true);;
//            checkbox.ClickedMouse();
//            return true;
//        }
//    }
}