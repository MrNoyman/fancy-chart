/*
 * Copyright (C) 2014 TESIS DYNAware GmbH.
 * All rights reserved. Use is subject to license terms.
 * 
 * This file is licensed under the Eclipse Public License v1.0, which accompanies this
 * distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 */
package de.tesis.dynaware.javafx.fancychart.data.importer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CSVImporter {

	private static CSVReader reader;

	public static List<List<Double>> importCSV(String filePath) {
		try {
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> entries = reader.readAll();
			List<List<Double>> vals = new ArrayList<>(entries.size());

			for (String[] entry : entries) {
				List<Double> l = new ArrayList<>();
				for (String string : entry) {
					l.add(Double.parseDouble(string));
				}
				vals.add(l);

			}
			reader.close();
			return vals;
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return Collections.emptyList();
	}
}