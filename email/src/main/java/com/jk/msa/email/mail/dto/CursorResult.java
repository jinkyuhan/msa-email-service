package com.jk.msa.email.mail.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CursorResult<T> {
  private T[] values;
  private boolean hasNext;
}
