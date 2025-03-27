import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import java.util.List;

public class TesteComponente {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @Test
    public void preencherCamposTexto() {
        // Preenchendo os campos de texto
        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        WebElement address = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        WebElement email = driver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        WebElement phone = driver.findElement(By.cssSelector("input[ng-model='Phone']"));
        WebElement password = driver.findElement(By.cssSelector("input[ng-model='Password']"));
        WebElement conpassword = driver.findElement(By.cssSelector("input[ng-model='CPassword']"));

        firstName.sendKeys("John");
        lastName.sendKeys("Teste");
        address.sendKeys("Rua rua, 123");
        email.sendKeys("email@email.com");
        phone.sendKeys("1234567890");
        password.sendKeys("12345");
        conpassword.sendKeys("12345");

        // Verificando se os valores foram preenchidos
        Assert.assertEquals("John", firstName.getAttribute("value"));
        Assert.assertEquals("Teste", lastName.getAttribute("value"));
        Assert.assertEquals("Rua rua, 123", address.getAttribute("value"));
        Assert.assertEquals("email@email.com", email.getAttribute("value"));
        Assert.assertEquals("1234567890", phone.getAttribute("value"));
        Assert.assertEquals("12345", password.getAttribute("value"));
        Assert.assertEquals("12345", conpassword.getAttribute("value"));
    }

    @Test
    public void selecionarGenero() {
        // Selecionando o radio button de gênero
        List<WebElement> radioButtons = driver.findElements(By.name("radiooptions"));
        WebElement maleRadioButton = radioButtons.get(0); // Masculino
        maleRadioButton.click();

        Assert.assertTrue(maleRadioButton.isSelected());
    }

    @Test
    public void marcarHobbies() {
        // Selecionando os checkboxes para hobbies
        WebElement cricketCheckbox = driver.findElement(By.id("checkbox1"));
        WebElement moviesCheckbox = driver.findElement(By.id("checkbox2"));

        cricketCheckbox.click();
        moviesCheckbox.click();

        Assert.assertTrue(cricketCheckbox.isSelected());
        Assert.assertTrue(moviesCheckbox.isSelected());
    }

    @Test
    public void selecionarSkills() {
        // Selecionando um valor no menu suspenso Skills
        WebElement skillsDropdown = driver.findElement(By.id("Skills"));
        Select skillsSelect = new Select(skillsDropdown);

        skillsSelect.selectByVisibleText("Java");
        Assert.assertEquals("Java", skillsSelect.getFirstSelectedOption().getText());
    }

    @Test
    public void selecionarCountry() {
        // Selecionando um valor no menu suspenso Skills
        WebElement clicar = driver.findElement(By.className("select2-selection"));
        clicar.click();
        WebElement SelecionaPais = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
        SelecionaPais.sendKeys("Bangladesh");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        SelecionaPais.sendKeys(Keys.ENTER);
    }

    @Test
    public void selecionarLinguagem() {
        // Selecionando um valor no menu suspenso Skills
        WebElement clicar = driver.findElement(By.xpath("//*[@id=\"msdd\"]"));
        clicar.click();
        WebElement SelecionaLinguagem1 = driver.findElement(By.linkText("Urdu"));
        SelecionaLinguagem1.click();
        WebElement SelecionaLinguagem2 = driver.findElement(By.linkText("Malay"));
        SelecionaLinguagem2.click();
    }

    @Test
    public void preencherDataNascimento() {
        // Preenchendo a data de nascimento
        WebElement year = driver.findElement(By.id("yearbox"));
        WebElement month = driver.findElement(By.cssSelector("select[ng-model='monthbox']"));
        WebElement day = driver.findElement(By.id("daybox"));

        year.sendKeys("1916");
        Select monthSelect = new Select(month);
        monthSelect.selectByVisibleText("March");
        day.sendKeys("21");

        Assert.assertEquals("1916", year.getAttribute("value"));
        Assert.assertEquals("March", monthSelect.getFirstSelectedOption().getText());
        Assert.assertEquals("21", day.getAttribute("value"));
    }

    @Test
    public void inserirImagem(){
        WebElement inserir = driver.findElement(By.id("imagesrc"));
        inserir.sendKeys("C:\\Users\\Users\\Pictures\\Imagem\\Imgem.jpg");
    }

    @Test
    public void submeterFormulario() {
        // Submetendo o formulário
        WebElement submitButton = driver.findElement(By.id("submitbtn"));
        submitButton.click();

        // Verificando o texto do botão de submissão
        Assert.assertEquals("Submit", submitButton.getText());
    }
}
