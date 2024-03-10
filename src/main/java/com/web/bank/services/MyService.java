package com.web.bank.services;

import org.springframework.ui.ModelMap;

import com.web.bank.model.SdfcBank;

public interface MyService {
	public SdfcBank insert(SdfcBank user);
	public SdfcBank checkBal(SdfcBank u);
}
