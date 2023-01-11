package com.autentia.cqrs.adapter.secondary;

import com.autentia.cqrs.adapter.secondary.vo.AddressJPA;
import com.autentia.cqrs.adapter.secondary.vo.UserJPA;
import com.autentia.cqrs.domain.Address;
import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.domain.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseRepository implements UserRepository {

    private final UserJPARepository userJPARepository;
    private final AddressJPARepository addressJPARepository;

    @Autowired
    public DatabaseRepository(UserJPARepository userJPARepository, AddressJPARepository addressJPARepository) {
        this.userJPARepository = userJPARepository;
        this.addressJPARepository = addressJPARepository;
    }

    @Override
    public void createUser(User user) {
        final UserJPA userJPA = userJPARepository.save(toUserJPA(user));
        final Set<AddressJPA> addressesJPA = toAddressJPA(user.getAddresses(), userJPA.getId());
        addressesJPA.forEach(address -> addressJPARepository.save(address));
    }

    @Override
    public User findUserByNif(String nif) {
        final UserJPA userJPA = userJPARepository.findByNif(nif);
        if (userJPA == null) {
            throw new EntityNotFoundException("User not found");
        }
        return toUser(userJPA);
    }

    @Override
    public void updateUser(User user) {

        final UserJPA userJPAByNif = userJPARepository.findByNif(user.getNif());
        if (userJPAByNif == null) {
            throw new EntityNotFoundException("User not found");
        }

        final UserJPA userJPA = toUserJPA(user);
        userJPA.setId(userJPAByNif.getId());
        userJPARepository.save(userJPA);

        final Set<AddressJPA> addressesJPA = toAddressJPA(user.getAddresses(), userJPA.getId());
        addressesJPA.forEach(address -> addressJPARepository.save(address));
    }

    @Override
    public void deleteUserByNif(String nif) {
        final UserJPA userJPA = userJPARepository.findByNif(nif);
        userJPARepository.delete(userJPA);
    }

    private UserJPA toUserJPA(User user) {
        return new UserJPA(user.getNif(), user.getName(), user.getSurname(), user.getEmail(), new HashSet<>());
    }

    private Set<AddressJPA> toAddressJPA(Set<Address> addresses, Long userId) {
        final Set<AddressJPA> addressesJPA = new HashSet<>();
        addresses.stream()
                .forEach(address -> {
                    final AddressJPA addressJPA = new AddressJPA(address.getAddress(), address.getCity(), address.getRegion(), address.getPostalCode(), userId);
                    addressesJPA.add(addressJPA);
                });
        return addressesJPA;
    }

    private User toUser(UserJPA userJPA) {
        return new User(userJPA.getNif(), userJPA.getName(), userJPA.getSurname(), userJPA.getEmail(), toAddress(userJPA.getAddresses()));
    }

    private Set<Address> toAddress(Set<AddressJPA> jpaAddresses) {
        final Set<Address> addresses = new HashSet<>();
        jpaAddresses.stream()
                .forEach(jpaAddress -> {
                    final Address address = new Address(jpaAddress.getAddress(), jpaAddress.getCity(), jpaAddress.getRegion(), jpaAddress.getPostalCode());
                    addresses.add(address);
                });
        return addresses;
    }
}
