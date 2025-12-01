package plugins.quorum.Libraries.Interface.Accessibility.IOS;

import org.robovm.apple.uikit.*;
import quorum.Libraries.Interface.Controls.Button_;
import quorum.Libraries.Interface.Item_;



public class ButtonIOS extends ItemIOS {
    @Override
    public boolean isAccessibilityElement() {
        return true;
    }

    Button_ button;
    UIView view;

    public ButtonIOS(UIAccessibilityContainer container)
    {
        super(container);
        view = new UIView();
        view.setUserInteractionEnabled(true);
    }

    public void SetButton(Button_ button)
    {
        this.button = button;
    }

    public void Initialize(Button_ button) {
        SetButton(button);
        UIAccessibilityTraits traits = UIAccessibilityTraits.Button;
        this.setAccessibilityTraits(traits);
        super.Initialize(button);

        UITapGestureRecognizer tap = new UITapGestureRecognizer(g -> activate());
        view.addGestureRecognizer(tap);
        ((UIView) getAccessibilityContainer()).addSubview(view);

        UpdateViewFrame();
    }

    public void UpdateViewFrame() {
        view.setFrame(getAccessibilityFrame());
    }

    @Override
    public boolean activate() {
        button.Activate();
        return true;
    }
}
