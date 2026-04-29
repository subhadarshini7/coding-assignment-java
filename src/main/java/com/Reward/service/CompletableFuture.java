import org.springframework.scheduling.annotation.Async;
import java.util.concurrent.CompletableFuture;

@Async
public CompletableFuture<List<Transaction>> getTransactionsAsync(Long customerId, LocalDate start, LocalDate end) {

    List<Transaction> transactions =
            transactionRepository.findByCustomerIdAndDateBetween(customerId, start, end);

    return CompletableFuture.completedFuture(transactions);
}
