/*
 * This file is part of text-extras, licensed under the MIT License.
 *
 * Copyright (c) 2018 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.adventure.platform;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

/**
 * A factory for getting {@link Audience}s.
 * @see AdventurePlatform
 */
public final class Adventure {
  private Adventure() {}
  private static final AdventurePlatform PROVIDER = AdventureProvider0.provide();

  /**
   * Gets an audience for all online players, including the server's console.
   *
   * <p>The audience is dynamically updated as players join and leave.</p>
   *
   * @return the players' and console audience
   */
  public static @NonNull Audience everyone() {
    return PROVIDER.everyone();
  }

  /**
   * Gets an audience for the server's console.
   *
   * @return the console audience
   */
  public static @NonNull Audience console() {
    return PROVIDER.console();
  }

  /**
   * Gets an audience for all online players.
   *
   * <p>The audience is dynamically updated as players join and leave.</p>
   *
   * @return the players' audience
   */
  public static @NonNull Audience players() {
    return PROVIDER.players();
  }

  /**
   * Gets an audience for an individual player.
   *
   * <p>If the player is not online, messages are silently dropped.</p>
   *
   * @param playerId a player uuid
   * @return a player audience
   */
  public static @NonNull Audience player(@NonNull UUID playerId) {
    return PROVIDER.player(playerId);
  }

  /**
   * Gets or creates an audience containing all viewers with the provided permission.
   *
   * <p>The audience is dynamically updated as permissions change.</p>
   *
   * @param permission the permission to filter sending to
   * @return a permissible audience
   */
  public static @NonNull Audience permission(@NonNull Key permission) {
    return PROVIDER.permission(permission);
  }

  /**
   * Gets or creates an audience containing all viewers with the provided permission.
   *
   * <p>The audience is dynamically updated as permissions change.</p>
   *
   * @param permission the permission to filter sending to
   * @return a permissible audience
   */
  public static @NonNull Audience permission(@NonNull String permission) {
    return PROVIDER.permission(permission);
  }

  /**
   * Gets an audience for online players in a world, including the server's console.
   *
   * <p>The audience is dynamically updated as players join and leave.</p>
   *
   * @param worldId a world uuid
   * @return the world's audience
   */
  public static @NonNull Audience world(@NonNull UUID worldId) {
    return PROVIDER.world(worldId);
  }

  /**
   * Gets an audience for online players on a server, including the server's console.
   *
   * <p>If the platform is not a proxy, the audience defaults to everyone.</p>
   *
   * @param serverName a server name
   * @return a server's audience
   */
  public static @NonNull Audience server(@NonNull String serverName) {
    return PROVIDER.server(serverName);
  }
}