package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebUtils {

    // Espera até que o elemento esteja visível usando By
    public static WebElement esperarElementoVisivel(WebDriver driver, By localizador, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    // Espera até que o WebElement esteja visível
    public static WebElement esperarElementoVisivel(WebDriver driver, WebElement elemento, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        return wait.until(ExpectedConditions.visibilityOf(elemento));
    }

    // Valida se o texto está presente no elemento localizado por By
    public static void validarTexto(WebDriver driver, By localizador, String textoEsperado) {
        WebElement elemento = esperarElementoVisivel(driver, localizador, 10);
        String texto = elemento.getText().replaceAll("[\\n\\r]", "").trim();
        System.out.println("Texto capturado: " + texto);
        if (!texto.contains(textoEsperado)) {
            throw new AssertionError("Texto esperado não encontrado!");
        }
    }

    // Valida se o texto está presente no WebElement
    public static void validarTexto(WebDriver driver, WebElement elemento, String textoEsperado) {
        esperarElementoVisivel(driver, elemento, 10);
        String texto = elemento.getText().replaceAll("[\\n\\r]", "").trim();
        System.out.println("Texto capturado: " + texto);
        if (!texto.contains(textoEsperado)) {
            throw new AssertionError("Texto esperado não encontrado!");
        }
    }

    // Clica usando JavaScript
    public static void clicarComJS(WebDriver driver, WebElement elemento) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elemento);
    }

    // Scroll até o elemento
    public static void scrollAteElemento(WebDriver driver, WebElement elemento) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    // Verifica se o elemento está visível usando By
    public static boolean estaVisivel(WebDriver driver, By localizador) {
        try {
            return driver.findElement(localizador).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verifica se o WebElement está visível
    public static boolean estaVisivel(WebElement elemento) {
        try {
            return elemento.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    // Captura screenshot da tela
    public static void capturarScreenshot(WebDriver driver, String nomeArquivo) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = gerarTimestamp();
        File destino = new File("screenshots/" + nomeArquivo + "_" + timestamp + ".png");
        destino.getParentFile().mkdirs();
        try {
            org.apache.commons.io.FileUtils.copyFile(src, destino);
            System.out.println("Screenshot salva em: " + destino.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }

    // Gera timestamp para nome de arquivos
    public static String gerarTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    public static void esperarElementoClicavel(WebDriver driver, WebElement elemento, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(segundos) );
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }


    public static void validarTextoExato(WebDriver driver, WebElement elemento, String textoEsperado) {
        String textoAtual = elemento.getText().trim();
        if (!textoAtual.equals(textoEsperado.trim())) {
            throw new AssertionError("Texto esperado não encontrado!");
        }
    }

}
