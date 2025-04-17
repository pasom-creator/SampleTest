package pages;

import org.openqa.selenium.By;

public interface IElement {

    By smsButton = By.xpath("//*[@value='Отправить код']");
    By userField = By.xpath(".//*[@class = 'tico ellip']");

    boolean isHaveElement();
}
