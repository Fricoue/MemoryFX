package objets;

import com.example.memoire.PartieController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Carte {
    private String idPaire;
    private final Image image;
    private boolean visible;
    private ImageView imageView;
    private Image imageFaceCachee = new Image("C:\\Users\\enzof\\IdeaProjects\\memoire\\src\\main\\resources\\cartes\\facecachee.png");

    public Carte(String idPaire, Image image) {
        this.idPaire = idPaire;
        this.image = image;
        this.visible = false;
        this.imageView = new ImageView();
        this.imageView.setImage(imageFaceCachee);

        this.imageView.setPreserveRatio(true);
        this.imageView.setFitHeight(120);

        this.imageView.setOnMousePressed(PartieController::retournerCarte);
    }

    public String getIdPaire() {
        return idPaire;
    }

    public void setIdPaire(String idPaire) {
        this.idPaire = idPaire;
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

    public boolean getVisible() {
        return this.visible;
    }
}
