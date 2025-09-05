package com.lumen.steamapi;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class HBankTransactions {

//	Bank Transactions Summary
//	Input: A List<Transaction> (id, customerName, amount, type[DEBIT/CREDIT], date).
//	Tasks:
//	Find total transaction amount (Collectors.summingDouble).
//	Count how many transactions were CREDIT vs DEBIT (Collectors.groupingBy).
//	Get the highest transaction per customer (Collectors.collectingAndThen(maxBy(...))).
//	Collect all unique customers into a Set (Collectors.toSet).

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		List<EntityBankTransaction> transactions = new ArrayList<>();
		
		// 10 customers
		for (int custId = 1; custId <= 10; custId++) {
			String customerName = "Customer" + custId;

			// Each customer gets 5–10 transactions
			int transactionCount = 5 * custId; // 5 to 10

			for (int t = 1; t <= transactionCount; t++) {
				int id = (custId * 100) + t; 
				double amount = Double.valueOf(1000 + (500*t*custId)); 
				CardType cardType = ((t/custId)%(amount)/2) == 0 ? CardType.DEBIT : CardType.CREDIT;
				LocalDate date = LocalDate.now().minusDays(t/custId); 

				EntityBankTransaction txn = new EntityBankTransaction(id, customerName, amount, cardType, date);
				transactions.add(txn);
			}
		}

		// Print all transactions
		//transactions.forEach(System.out::println);

		// Optional: total count
		//System.out.println("Total transactions generated: " + transactions.size());
		
		

		System.err.println("************************************************");
//		Find total transaction amount (Collectors.summingDouble).
		String cName  = "Customer6";
		System.out.println(transactions);
		double sum = transactions.stream()
					.filter(ft -> ft.getCustomerName().equals(cName))
					.mapToDouble(EntityBankTransaction::getAmmout)
					.sum();		
		System.out.println("Sum of amout for "+ cName +" -> "+ sum);
		
		System.out.println("************************************************");
		Double collect = transactions.stream()
									 .filter(ft -> ft.getCustomerName().equals(cName))
									 .collect(Collectors.summingDouble(EntityBankTransaction::getAmmout));
		System.out.println("Sum of amout for "+ cName +" -> "+ collect);
		
		System.err.println("************************************************");
//		Count how many transactions were CREDIT vs DEBIT (Collectors.groupingBy).
		Map<Enum, Long> countByType = transactions.stream()
		        .collect(Collectors.groupingBy(
		                EntityBankTransaction::getCardType,
		                Collectors.counting()
		        ));

		long debitCount  = countByType.getOrDefault(CardType.DEBIT, 0L);
		long creditCount = countByType.getOrDefault(CardType.CREDIT, 0L);

		System.out.println("Debit count: " + debitCount);
		System.out.println("Credit count: " + creditCount);
		System.out.println("************************************************");		
		Map<Enum, Long> countByType1 = transactions.stream()
		        								.collect(Collectors.groupingBy(EntityBankTransaction::getCardType, Collectors.counting()));
		System.out.println("Count by type: " + countByType1);
		
		
		
		System.err.println("************************************************");
//		Get the highest transaction per customer (Collectors.collectingAndThen(maxBy(...))).
		Map<String, Optional<EntityBankTransaction>> highestPerCustomer =
		        transactions.stream()
		                .collect(Collectors.groupingBy(
		                        EntityBankTransaction::getCustomerName,
		                        Collectors.maxBy(Comparator.comparingDouble(EntityBankTransaction::getAmmout))
		                ));

		System.out.println("Highest transaction per customer: " + highestPerCustomer);
//		Collect all unique customers into a Set (Collectors.toSet).
		System.err.println("************************************************");
		Set<String> customers = transactions.stream()
		        							.map(txn -> txn.getCustomerName())   
		        							.collect(Collectors.toSet());
		for (String entityBankTransaction : customers) {			
			System.out.println(entityBankTransaction);			
		}
		//System.out.println("************************************************");
		
		
		
		
	}
}
