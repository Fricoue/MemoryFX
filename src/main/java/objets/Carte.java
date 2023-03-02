package objets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Carte {
    private final String idPaire;
    private final Image image;
    private boolean visible;
    private ImageView imageView;
    private final Image imageFaceCachee = new Image("/cartes/facecachee.png");

    public Carte(String idPaire, Image image) {
        this.idPaire = idPaire;
        this.image = image;
        this.visible = false;
        this.imageView = new ImageView();
        this.imageView.setImage(imageFaceCachee);
    }

    public String getIdPaire() {
        return idPaire;
    }

    public Image getImage() {
        return image;
    }

    public boolean visible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void retourner() {
        if (visible) {
            visible = false;
            imageView.setImage(imageFaceCachee);
        } else {
            visible = true;
            imageView.setImage(image);
        }
    }

    public boolean estPaire(Carte carte) {
        return this.idPaire.equals(carte.getIdPaire());
    }
}
