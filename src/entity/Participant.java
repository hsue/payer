package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hsue on 12/16/18.
 */
@MappedSuperclass
public class Participant implements Serializable{

  private Image image;
  private String name;

  @ManyToOne
  @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = true)
  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  @Basic
  @Column(name = "name", nullable = true, length = 45)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
