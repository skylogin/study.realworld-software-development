package main.java.document;

import static main.java.document.Attributes.HEIGHT;
import static main.java.document.Attributes.PATH;
import static main.java.document.Attributes.TYPE;
import static main.java.document.Attributes.WIDTH;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ImageImporter implements Importer{

  @Override
  public Document importFile(File file) throws IOException {
    final Map<String, String> attributes = new HashMap<>();

    attributes.put(PATH, file.getPath());

    final BufferedImage image = ImageIO.read(file);
    attributes.put(WIDTH, String.valueOf(image.getWidth()));
    attributes.put(HEIGHT, String.valueOf(image.getHeight()));
    attributes.put(TYPE, "IMAGE");

    return new Document(attributes);
  }

}
