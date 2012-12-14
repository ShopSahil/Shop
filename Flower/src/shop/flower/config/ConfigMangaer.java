package shop.flower.config;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigMangaer {


	private static ConfigMangaer cm = null;
	private static Properties p = null;
	
	private ConfigMangaer() {
		reload();
	}
	
	public static ConfigMangaer getInstance() {
		if (cm == null) {
			cm = new ConfigMangaer();
		}
		
		return cm;
	}
	
	private void reload() {
		p = new Properties();
		
		String packageName = this.getClass().getPackage().getName() + ".config";
		ResourceBundle bundle = ResourceBundle.getBundle(packageName);
		
		for (String key : bundle.keySet()) {
			p.put(key, bundle.getObject(key));
		}
	}
	
	public Properties getProperties() {
		if (p == null) {
			this.reload();
		}
		
		return p;
	}
	
	public String getProperty(String propertyName) {
		if (p == null) {
			this.reload();
		}
		
		return p.getProperty(propertyName);
	}
	
	public boolean isValid() {
		return p != null && p.size() > 0;
	}
}

