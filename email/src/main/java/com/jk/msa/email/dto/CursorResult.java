package com.jk.msa.email.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CursorResult<T> {
  private T[] values;
  private boolean hasNext;
}
