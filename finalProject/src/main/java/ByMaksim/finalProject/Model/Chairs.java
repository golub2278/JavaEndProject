package ByMaksim.finalProject.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Chairs")
public class Chairs {

    @Id
    @Column(name = "Id")
    public long id;

    @Column(name = "Model")
    public String model;

    @Column(name = "Description")
    public String description;

    @Column(name = "Price")
    public double price;

    @Column(name = "Image_URL")
    public String image_URL;
}
