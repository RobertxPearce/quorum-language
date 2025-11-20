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

        setAccessibilityLabel(radioButton.getText());

        String tempValue;
        if (radioButton.GetToggleState()){
            tempValue = "selected";
        }
        else {
            tempValue = "not selected";
        }
        setAccessibilityValue(tempValue);


        UIAccessibilityTraits traits = UIAccessibilityTraits.Button;
        if(radioButton.GetToggleState()){
            traits = traits.plus(UIAccessibilityTraits.Selected);
        }

        setAccessibilityTraits(traits);
        super.Initialize(radioButton);

    }


    @Override
    public boolean activate() {
        boolean isToggled = radioButton.GetToggleState();

        if (isToggled) {
//            radioButton.Activate();
//            radioButton.SetToggleState(false);
//            radioButton.ClickedMouse();
            return true;
        } else {
            radioButton.SetToggleState(true);
            radioButton.Activate();
            radioButton.ClickedMouse();

            setAccessibilityValue("selected");
            setAccessibilityTraits(UIAccessibilityTraits.Button.plus(UIAccessibilityTraits.Selected));

            return true;
        }



    }
}
