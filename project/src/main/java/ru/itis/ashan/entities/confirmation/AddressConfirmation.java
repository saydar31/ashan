package ru.itis.ashan.entities.confirmation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.ashan.entities.user.UserModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class AddressConfirmation {
    @Id
    private String hash;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private UserModel userModel;
}
