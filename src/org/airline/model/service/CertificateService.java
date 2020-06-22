package org.airline.model.service;

import org.airline.model.entity.Certificate;
import org.airline.model.repository.CertificateDA;

import java.util.List;

public class CertificateService {
    private static CertificateService ourInstance = new CertificateService();

    private CertificateService() {
    }

    public static CertificateService getInstance(){
        return ourInstance;
    }

    public void save(Certificate certificate) throws Exception {
        try (CertificateDA certificateDA = new CertificateDA()) {
            certificateDA.insert(certificate);
        }
    }

    public void update(Certificate certificate) throws Exception {
        try (CertificateDA certificateDA = new CertificateDA()) {
            certificateDA.update(certificate);
        }
    }

    public void delete(Certificate certificate) throws Exception {
        try (CertificateDA certificateDA = new CertificateDA()) {
            certificateDA.delete(certificate);
        }
    }

    public Certificate findOne(Certificate certificate) throws Exception {
        try (CertificateDA certificateDA = new CertificateDA()) {
            return certificateDA.selectOne(certificate);
        }
    }

    public Certificate findOneById(Integer id) throws Exception {
        try (CertificateDA certificateDA = new CertificateDA()) {
            return certificateDA.selectOneById(id);
        }
    }

    public List<Certificate> findAll() throws Exception {
        try (CertificateDA certificateDA = new CertificateDA()) {
            return certificateDA.selectAll();
        }
    }
}
