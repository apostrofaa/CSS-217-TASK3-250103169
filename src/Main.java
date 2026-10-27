interface Internet {
    void connectTo(String site);
}
class RealInternet implements Internet {
    public void connectTo(String site) {
        System.out.println("Connected to site: " + site);
    }
}
class SchoolProxyInternet implements Internet {
    private RealInternet realInternet;
    public void connectTo(String site) {
        if ("gaming.com".equals(site) || "socialmedia.com".equals(site)) {
            System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
            return;
        }
        if (realInternet == null) {
            realInternet = new RealInternet();
        }
        realInternet.connectTo(site);
    }
}
public class Main {
    public static void main(String[] args) {
        Internet schoolWifi = new SchoolProxyInternet();

        schoolWifi.connectTo("wikipedia.org");
        schoolWifi.connectTo("gaming.com");
    }
}