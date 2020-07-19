package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.ashan.entities.confirmation.AddressConfirmation;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.exceptions.UserNotFoundException;
import ru.itis.ashan.repositories.AddressConfirmationRepository;

import java.util.Optional;

@Component
public class MailConfirmationServiceImpl implements MailConfirmationService {
    @Autowired
    private AddressConfirmationRepository addressConfirmationRepository;


    private String getHash() {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWZYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int randomInt = (int) (Math.random() * alphabet.length());
            stringBuilder.append(alphabet.charAt(randomInt));
        }
        stringBuilder.append(System.currentTimeMillis());
        return stringBuilder.toString();
    }

    @Override
    public String getConfirmationString(UserModel userModel) {
        String hash = getHash();
        AddressConfirmation addressConfirmation = new AddressConfirmation(hash, userModel);
        addressConfirmationRepository.save(addressConfirmation);
        return hash;
    }

    @Override
    @Transactional
    public void confirm(String hash) {
        Optional<AddressConfirmation> addressConfirmationOptional = addressConfirmationRepository.findById(hash);
        if (addressConfirmationOptional.isPresent()) {
            AddressConfirmation addressConfirmation = addressConfirmationOptional.get();
            UserModel userModel = addressConfirmation.getUserModel();
            userModel.setEmailIsConfirmed(true);
            addressConfirmationRepository.delete(addressConfirmation);
        } else {
            throw new UserNotFoundException();
        }
    }
}
