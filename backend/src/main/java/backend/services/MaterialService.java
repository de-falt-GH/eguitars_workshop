package backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.models.Material;
import backend.repos.MaterialRepository;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materials;

    @Transactional(readOnly = true)
    public List<Material> getAll() {
        return materials.findAll();
    }

    @Transactional
    public void save(Material material) {
        materials.save(material);
    }

    @Transactional
    public void deleteById(long id) {
        materials.deleteById(id);
    }

    @Transactional
    public void updateNumById(long id, int value) {
        if (value <= 0) {
            materials.deleteById(id);
        } else {
            var material = materials.findById(id).get();
            material.setAmount(value);
            materials.save(material);
        }
    }
}
