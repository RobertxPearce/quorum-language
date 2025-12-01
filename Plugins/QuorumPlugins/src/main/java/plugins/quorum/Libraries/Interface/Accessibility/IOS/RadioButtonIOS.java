package plugins.quorum.Libraries.Interface.Accessibility.IOS;

import org.robovm.apple.uikit.*;
import quorum.Libraries.Interface.Controls.RadioButton_;
import quorum.Libraries.Interface.Controls.ToggleButton_;
import quorum.Libraries.Interface.Item_;
public class RadioButtonIOS extends ItemIOS {
    @Override
    public boolean isAccessibilityElement() {
        return true;
    }

    public RadioButtonIOS(UIAccessibilityContainer container) {
        super(container);
    }

    RadioButton_ radioButton;

    public void setRadioButton(RadioButton_ radioButton) {
        this.radioButton = radioButton;
    }

    public void Initialize(RadioButton_ radioButton) {
        setRadioButton(radioButton);
        UIAccessibilityTraits traits = UIAccessibilityTraits.None;
        this.setAccessibilityTraits(traits);
        super.Initialize(radioButton);
    }

    @Override
    public boolean activate() {

///////////////Aidan and Nirbhay worked on this in a call///////////////
        boolean isToggled = toggleButton.GetToggleState();
        if(isToggled){
            toggleButton.Activate();
            toggleButton.ClickedMouse();
            toggleButton.SetToggleState(false);
            return false;
        }
        else{
            toggleButton.SetToggleState(false);
            return true;
        }



///////////////OLD CODE FOR REFERENCE///////////////
//        boolean isToggled = radioButton.GetToggleState();
//        if (isToggled == true) {
//            radioButton.Activate();
//            radioButton.SetToggleState(false);
//            radioButton.ClickedMouse();
//            return false;
//        } else {
//            radioButton.Activate();
//            radioButton.SetToggleState(true);;
//            radioButton.ClickedMouse();
//            return true;
//        }
    }
}
