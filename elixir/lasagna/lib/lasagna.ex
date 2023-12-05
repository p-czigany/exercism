defmodule Lasagna do
  @moduledoc """
  This modul is for baking lasagna.
  """

  @LAYER_PREPARATION_MINUTES 2

  @doc """
  Expected baking time.

  ## Examples

      iex> Lasagna.expected_minutes_in_oven
      40

  """
  @spec expected_minutes_in_oven() :: integer
  def expected_minutes_in_oven do
    40
  end

  @doc """
  Remaining minutes from baking.

  ## Examples

      iex> Lasagna.remaining_minutes_in_oven(25)
      15

  """
  @spec remaining_minutes_in_oven(cooking_time :: integer) :: integer
  def remaining_minutes_in_oven(cooking_time) do
    expected_minutes_in_oven() - cooking_time
  end


  @doc """
  Preparation time in minutes.

  ## Examples

      iex> Lasagna.preparation_time_in_minutes(4)
      8

  """
  @spec preparation_time_in_minutes(number_of_layers :: integer) :: integer
  def preparation_time_in_minutes(number_of_layers) do
    number_of_layers * LAYER_PREPARATION_MINUTES
  end

  # Please define the 'total_time_in_minutes/2' function

  # Please define the 'alarm/0' function
end
