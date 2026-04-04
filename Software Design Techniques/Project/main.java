public class Main {
  public static void main(String[] args) {

    // init devices
    Devices.deviceStartUp();
    

    UIManager UI = new UIManager();

    UI.getHomePage();
  }
}