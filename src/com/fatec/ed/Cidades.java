package com.fatec.ed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Comparator;

public class Cidades {

	public List<String> listaCidades = null;
	public HashLinear hashLinear = null;
	public HashLinkedList hashLinkedList = null;

	public Cidades(String path) {
		super();
		this.listaCidades = this.carregaCidades(path);
	}


	public List<String> carregaCidades(String path) {
		
		List<String> dados = new ArrayList<String>();
		
		try {
			
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			String linha = "";
			boolean flag = true;
			
			while (flag) {
				linha = leitor.readLine();
				if (linha != null) {
					String temp = linha;
					dados.add(temp);
				} else {
					flag = false;
				}
			}
			
			leitor.close();
			
			Collections.sort(dados, Collator.getInstance());
			
			return dados;
			
		} catch (FileNotFoundException e) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Arquivo "+ path +" não encontrado :( , Crie-o ande de executar essa operação :) ");
	        System.out.println("--------------------------------------------");
			return null;
		} catch (IOException e) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Arquivo "+ path +" não encontrado :( , Crie-o ande de executar essa operação :) ");
	        System.out.println("--------------------------------------------");
			return null;
		}
	}
	
	public HashLinear iniciarHashLinear() {
		
		if(this.listaCidades == null) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Dados do Arquivo não encontrado :( , Crie-o ande de executar essa operação :) ");
	        System.out.println("--------------------------------------------");
			return null;
		}
		
		HashLinear tabelaHash = new HashLinear(this.listaCidades.size());
		
		for(String cidade: this.listaCidades) {
			tabelaHash.insere(cidade);
		}
		
		return tabelaHash;
	}

	public void imprimirHashLinear() {
		
		if(this.hashLinear == null) {
			System.out.print("Hash Linar n�o inicializado :(");
		}else {
			this.hashLinear.imprime();
		}
	
	}
	
	public HashLinkedList iniciarHashLinkedList() {
		
		if(this.listaCidades == null) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Dados do Arquivo não encontrado :( , Crie-o ande de executar essa operação :) ");
	        System.out.println("--------------------------------------------");
			return null;
		}
		
		HashLinkedList tabelaHash = new HashLinkedList(this.listaCidades.size());
		
		for(String cidade: this.listaCidades) {
			tabelaHash.put(cidade);
		}
		
		return tabelaHash;
	}
	
	public void imprimirHashLinkedList() {
		
		if(this.hashLinkedList == null) {
			System.out.print("Hash n�o inicializado :(");
		}else {
			this.hashLinkedList.printHashTable();
		}
	
	}
}