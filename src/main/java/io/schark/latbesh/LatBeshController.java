package io.schark.latbesh;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Player_Schark
 */
public class LatBeshController {

	private static final List<String> AURE = Arrays.asList(":SWUABaurek:", ":SWUABbesh:", ":SWUABcresh:", ":SWUABdorn:", ":SWUABesk:", ":SWUABforn:", ":SWUABgrek:", ":SWUABherf:", ":SWUABisk:", ":SWUABjenth:", ":SWUABkrill:", ":SWUABlenth:", ":SWUABmern:", ":SWUABnern:", ":SWUABosk:", ":SWUABpeth:", ":SWUABqek:", ":SWUABresh:", ":SWUABsenth:", ":SWUABtrill:", ":SWUABusk:", ":SWUABvev:", ":SWUABwesk:", ":SWUABxesh:", ":SWUAByirt:", ":SWUABzerek:", ":SWUABaurek::SWUABesk:", ":SWUABosk::SWUABesk:", ":SWUABusk::SWUABesk:", ":SWUABsenth::SWUABsenth:");
	private static final List<String> LATIN = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "ä", "ö", "ü", "ß");
	private static final Pattern TRANSLATE_PATTERN = Pattern.compile(":SWUAB[a-zA-Z]+:");

	@FXML
	private TextField latText;

	@FXML
	private TextField aureText;

	@FXML
	protected void onLatClick() {
		this.latText.setText(this.translate(this.aureText.getText(), false));
	}

	@FXML
	protected void onAureClick() {
		this.aureText.setText(this.translate(this.latText.getText(), true));
	}

	private String translate(String text, boolean toAure) {
		StringBuilder result = new StringBuilder();
		if (toAure) {
			text = text.toLowerCase(Locale.ROOT);
			for (String letter : text.split("")) {
				int index = LATIN.indexOf(letter);
				String l = index >= 0 ? AURE.get(index) : letter;
				result.append(l);
			}
		} else {
			Matcher matcher = TRANSLATE_PATTERN.matcher(text);
			while (matcher.find()) {
				String group = matcher.group();
				int index = AURE.indexOf(group);
				if (index < 0) {
					continue;
				}
				text = text.replaceAll(group, LATIN.get(index));
				matcher = TRANSLATE_PATTERN.matcher(text);
			}
			result.append(text);
		}
		return result.toString();
	}
}