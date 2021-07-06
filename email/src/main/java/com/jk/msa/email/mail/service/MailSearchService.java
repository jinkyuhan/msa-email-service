package com.jk.msa.email.mail.service;

import java.util.List;
import java.util.Optional;

import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.SearchOptionDto;
import com.jk.msa.email.common.exception.RequestFailException;
import com.jk.msa.email.mail.entity.Mail;
import com.jk.msa.email.mail.repository.MailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MailSearchService {

  @Autowired
  private MailRepository mailRepository;

  public List<Mail> search(SearchOptionDto searchOption) {
    String queryInput = Optional.ofNullable(searchOption.getQuery()).orElse("");
    if (queryInput.isBlank()) {
      return mailRepository.findAll();
    }
    switch (searchOption.getSubject()) {
      case "receiverId":
        return mailRepository.findByReceiverId(queryInput);
      case "title":
        return mailRepository.findByTitleContaining(queryInput);
      case "body":
        return mailRepository.findByBodyContaining(queryInput);
      default:
        throw new RequestFailException(ApiResult.BAD_PARAMETER);
    }
  }

  public Mail searchById(String id) {
    return mailRepository.findById(id).orElse(null);
  }

  public List<Mail> searchWithPagination(SearchOptionDto searchOption, PageRequest pageRequest) {
    String queryInput = Optional.ofNullable(searchOption.getQuery()).orElse("");
    if (queryInput.isBlank()) {
      return mailRepository.findAll(pageRequest).toList();
    }
    switch (searchOption.getSubject()) {
      case "receiverId":
        return mailRepository.findByReceiverId(queryInput, pageRequest).toList();
      case "title":
        return mailRepository.findByTitleContaining(queryInput, pageRequest).toList();
      case "body":
        return mailRepository.findByBodyContaining(queryInput, pageRequest).toList();
      default:
        throw new RequestFailException(ApiResult.BAD_PARAMETER);
    }
  }
}