package de.larssh.utils.time;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import de.larssh.utils.CompletedException;
import lombok.ToString;
import lombok.experimental.NonFinal;

/**
 * Abstract and synchronized implementation of a closeable {@link Stopwatch}.
 * Once a {@code CloseableStopwatch} is closed no more checkpoints can be
 * created and {@link #sinceStart()} and {@link #sinceLast()} return durations
 * based on the stopwatches stopping time.
 *
 * <p>
 * Extending class are meant to be used inside try-with-resource blocks.
 *
 * <p>
 * {@link #close()} can be called multiple times while all but the first call
 * are ignored.
 */
@ToString(callSuper = true)
public abstract class CloseableStopwatch extends Stopwatch implements AutoCloseable {
	@NonFinal
	volatile Optional<Instant> stopInstant = Optional.empty();

	/**
	 * Object used for locking
	 */
	@ToString.Exclude
	Object lock = new Object();

	/**
	 * Abstract and synchronized implementation of a closeable {@link Stopwatch}.
	 * Once a {@code CloseableStopwatch} is closed no more checkpoints can be
	 * created and {@link #sinceStart()} and {@link #sinceLast()} return durations
	 * based on the stopwatches stopping time.
	 *
	 * <p>
	 * Extending class are meant to be used inside try-with-resource blocks.
	 *
	 * <p>
	 * {@link #close()} can be called multiple times while all but the first call
	 * are ignored.
	 */
	public CloseableStopwatch() {
		super();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @throws CompletedException Once the {@link CloseableStopwatch} is closed no
	 *                            more checkpoints can be added.
	 */
	@Override
	public Checkpoint checkpoint(final String name) {
		synchronized (lock) {
			if (isStopped()) {
				throw new CompletedException();
			}
			return super.checkpoint(name);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void close() {
		synchronized (lock) {
			if (!isStopped()) {
				stopInstant = Optional.of(Instant.now());
			}
		}
	}

	/**
	 * Instant at the stopwatches stopping or empty if the stopwatch is not stopped,
	 * yet.
	 *
	 * @return the instant at the stopwatches stopping or empty
	 */
	public Optional<Instant> getStopInstant() {
		return stopInstant;
	}

	/**
	 * Returns {@code true} if the stopwatch is stopped.
	 *
	 * @return {@code true} if the stopwatch is stopped
	 */
	public boolean isStopped() {
		return stopInstant.isPresent();
	}

	/** {@inheritDoc} */
	@Override
	public Duration sinceLast() {
		return Duration.between(getLastInstant(), getStopInstant().orElseGet(Instant::now));
	}

	/** {@inheritDoc} */
	@Override
	public Duration sinceStart() {
		return Duration.between(getStartInstant(), getStopInstant().orElseGet(Instant::now));
	}
}